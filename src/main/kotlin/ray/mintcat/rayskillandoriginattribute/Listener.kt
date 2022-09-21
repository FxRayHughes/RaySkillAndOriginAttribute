package ray.mintcat.rayskillandoriginattribute

import ac.github.oa.api.OriginAttributeAPI
import ac.github.oa.internal.core.attribute.Attribute
import ac.github.oa.internal.core.attribute.AttributeManager
import com.sucy.skill.api.event.AttributeGetEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common5.Coerce

object Listener {

    @SubscribeEvent
    fun attribute(event: AttributeGetEvent) {

        val attributeData = OriginAttributeAPI.getAttributeData(event.caster)
        val split = event.attribute.split(".")
        val instance = AttributeManager.getAttribute(split[0])
        val entry = instance.getEntry(split[1])
        val data = attributeData.getData(instance.getPriority(), entry.index)

        event.value = when (entry.type) {
            Attribute.Type.RANGE -> Coerce.toInteger(data.random())
            Attribute.Type.SINGLE -> Coerce.toInteger(data.get())
            Attribute.Type.PERCENT -> Coerce.toInteger(data.get() / 100)
        }
    }

}