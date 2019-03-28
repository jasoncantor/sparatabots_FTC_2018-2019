package org.firstinspires.ftc.teamcode;

/*
 * Created by Luke on 7/5/2017.
 */
public class Hex implements HexMotor {
    private final static int REV_CoreHexMotor_EncoderCountsPerRevolution = 288;
    private final static int REV_HDHexMotor_EncoderCountsPerRevolution = 2240;
    private final static double REV_90mmWheel_Circumference = (90*Math.PI);
    private final static double REV_60mmWheel_Circumference = (60*Math.PI);
    private final static double REV_30mmWheel_Circumference = (30*Math.PI);

    public final int getREV_CoreHexMotor_EncoderCountsPerRevolution () { return REV_CoreHexMotor_EncoderCountsPerRevolution; }

    public final int getREV_HDHexMotor_EncoderCountsPerRevolution () { return REV_HDHexMotor_EncoderCountsPerRevolution; }

    public final double getREV_90mmWheel_Circumference () {
        return REV_90mmWheel_Circumference;
    }

    public final double getREV_60mmWheel_Circumference () {
        return REV_60mmWheel_Circumference;
    }

    public final double getREV_30mmWheel_Circumference () { return REV_30mmWheel_Circumference; }
}
