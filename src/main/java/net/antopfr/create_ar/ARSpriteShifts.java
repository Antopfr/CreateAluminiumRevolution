package net.antopfr.create_ar;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;

import static com.simibubi.create.foundation.block.connected.AllCTTypes.*;

public class ARSpriteShifts {

    public static final CTSpriteShiftEntry ALUMINUM_CASING = ct(OMNIDIRECTIONAL, "aluminum_casing"),
            ALUMINUM_ENCASED_COGWHEEL_SIDE = ct(VERTICAL, "aluminum_encased_cogwheel_side"),
            ALUMINUM_ENCASED_COGWHEEL_OTHERSIDE = ct(HORIZONTAL, "aluminum_encased_cogwheel_side");

    private static CTSpriteShiftEntry ct(AllCTTypes type, String name) {
        return CTSpriteShifter.getCT(type,
                CreateAR.asResource("block/" + name),
                CreateAR.asResource("block/" + name + "_connected"));
    }
}
