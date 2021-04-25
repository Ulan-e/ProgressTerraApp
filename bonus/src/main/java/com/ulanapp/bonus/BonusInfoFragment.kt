package com.ulanapp.bonus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.ulanapp.bonus.di.BonusInfoComponentProvider
import com.ulanapp.bonus.utils.convertDateToDayMonth
import com.ulanapp.network.actions.APIAccessTokenActions
import com.ulanapp.network.actions.APIBonusInfoActions
import com.ulanapp.network.responses.BonusInfoResponse
import com.ulanapp.network.responses.RequestBody
import kotlinx.android.synthetic.main.bonus_info_fragment.*
import javax.inject.Inject

class BonusInfoFragment : Fragment() {

    @Inject
    lateinit var apiAccessTokenActions: APIAccessTokenActions

    @Inject
    lateinit var apiBonusInfoActions: APIBonusInfoActions

    private lateinit var model: BonusInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as BonusInfoComponentProvider)
                .provideBonusInfoComponent()
                .inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bonus_info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar(view)

        val requestBody = createRequestBody()

        model = ViewModelProvider(
                this,
                BonusInfoViewModelFactory(apiAccessTokenActions, apiBonusInfoActions)
        ).get(BonusInfoViewModel::class.java)

        // загрузка данных
        model.loadBonusData(requestBody)

        // получаем информацию о бонусе
        model.bonusInfo.observe(viewLifecycleOwner, Observer {
            setBonusInfo(it)
        })
    }

    // настраиваем тулбар
    private fun setupToolbar(view: View) {
        val toolbar = view.findViewById<Toolbar>(R.id.main_toolbar)
        toolbar.title = resources.getString(R.string.logo)
        toolbar.inflateMenu(R.menu.info_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.info -> {
                }
            }
            true
        }
        val mainToolbar = view.findViewById<CollapsingToolbarLayout>(R.id.toolbarlayout)
        mainToolbar.isTitleEnabled = false
    }

    // создание RequestBody для API запроса
    private fun createRequestBody(): RequestBody {
        return RequestBody(
                resources.getString(R.string.client_id),
                "",
                resources.getString(R.string.device),
                resources.getString(R.string.device_id),
                resources.getInteger(R.integer.one),
                resources.getInteger(R.integer.one),
                resources.getInteger(R.integer.one)
        )
    }

    // показываем информацию о бонусе
    private fun setBonusInfo(bonusInfo: BonusInfoResponse.Data) {
        tvAmountBonus.text = getString(R.string.bonus, bonusInfo.currentQuantity.toString())
        tvRemainBonus.text = getString(R.string.bonus, bonusInfo.forBurningQuantity.toString())
        val month = bonusInfo.dateBurning.convertDateToDayMonth()
        tvBonusExpiresDate.text = getString(R.string.bonus, month)
    }
}