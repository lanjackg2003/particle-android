package io.particle.android.sdk.controlpanel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.particle.sdk.app.R
import kotlinx.android.synthetic.main.fragment_cp_congrats.*
import kotlinx.coroutines.delay


class ControlPanelCongratsFragment : BaseControlPanelFragment() {

    override val titleBarOptions = TitleBarOptions()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cp_congrats, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        p_hashtagwinning_message.text = responseReceiver?.singleTaskCongratsMessage

        if (!flowScopes.job.isCancelled) {
            flowScopes.onMain {
                delay(2000)
                if (!isDetached && isAdded && isVisible) {
                    findNavController().popBackStack()
                }
            }
        }
    }

}