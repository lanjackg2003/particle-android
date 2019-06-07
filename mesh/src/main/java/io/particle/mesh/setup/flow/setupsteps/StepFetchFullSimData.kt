package io.particle.mesh.setup.flow.setupsteps

import io.particle.android.sdk.cloud.ParticleCloud
import io.particle.mesh.setup.flow.FlowUiDelegate
import io.particle.mesh.setup.flow.MeshSetupStep
import io.particle.mesh.setup.flow.Scopes
import io.particle.mesh.setup.flow.context.SetupContexts


class StepFetchFullSimData(
    private val cloud: ParticleCloud,
    private val flowUi: FlowUiDelegate
) : MeshSetupStep() {

    override suspend fun doRunStep(ctxs: SetupContexts, scopes: Scopes) {
        if (ctxs.targetDevice.sim != null) {
            return
        }

        flowUi.showGlobalProgressSpinner(true)
        try {
            val sim = cloud.getSim(ctxs.targetDevice.iccid!!)
            ctxs.targetDevice.sim = sim
        } finally {
            flowUi.showGlobalProgressSpinner(false)
        }
    }

}