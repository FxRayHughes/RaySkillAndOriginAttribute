package ray.mintcat.rayskillandoriginattribute

import ac.github.oa.api.OriginAttributeAPI
import ac.github.oa.internal.core.attribute.AttributeManager
import com.sucy.skill.api.event.AttributeGetEvent
import taboolib.common.platform.event.SubscribeEvent

object Listener {

    @SubscribeEvent
    fun attribute(event: AttributeGetEvent) {
        val data = OriginAttributeAPI.getAttributeData(event.caster)
        val attr = AttributeManager.getAttribute(event.attribute)
    }

}