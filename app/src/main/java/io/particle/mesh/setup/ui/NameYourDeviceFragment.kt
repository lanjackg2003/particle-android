package io.particle.mesh.setup.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.particle.android.sdk.cloud.ParticleCloud
import io.particle.mesh.common.QATool
import io.particle.sdk.app.R
import kotlinx.android.synthetic.main.fragment_name_your_device.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch


class NameYourDeviceFragment : BaseMeshSetupFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_name_your_device, container, false)

        root.action_next.setOnClickListener {
            val name = root.deviceNameInputLayout.editText!!.text.toString()
            flowManagerVM.flowManager!!.updateTargetDeviceNameToAssign(name)
        }

        return root
    }

}
