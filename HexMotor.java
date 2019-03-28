package org.firstinspires.ftc.teamcode;

/*
 * Created by Luke on 7/5/2017.
 */

public interface HexMotor {
    /*
     * returns the counts per revolution of the REV Core Hex Motor
     * @return
     * */
    int getREV_CoreHexMotor_EncoderCountsPerRevolution ();
    /**
     * returns the counts per revolution of the REV HD Hex Motor
     * @return
     */
    int getREV_HDHexMotor_EncoderCountsPerRevolution ();
    /*
     * Returns the circumference of the REV 90mm wheel
     * @return
     */
    double getREV_90mmWheel_Circumference();
    /*
     * Returns the circumference of the REV 60mm wheel
     * @return
     */
    double getREV_60mmWheel_Circumference ();
    /*
     * Returns the circumference of the REV 30mm wheel
     * @return
     */
    double getREV_30mmWheel_Circumference ();
}
