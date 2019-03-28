package org.firstinspires.ftc.robotcontroller.external.samples;

import android.app.Activity;
import com.qualcomm.robotcore.hardware.DcMotor;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;
@TeleOp(name = "Sensor4: REVColorDistance", group = "Sensor")
//@Disabled                            // Comment this out to add to the opmode list
public class ColorSensor4 extends LinearOpMode {

    ColorSensor sensorColor;
    DcMotor Left, Right;
    
    @Override
    public void runOpMode() {


        Left  = hardwareMap.dcMotor.get("Left");
        Right = hardwareMap.dcMotor.get("Right");
        
        sensorColor = hardwareMap.get(ColorSensor.class, "color_sensor");
        float[] hsvValues = new float[3];
        final float values[] = hsvValues;
        final double SCALE_FACTOR = 255;
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);

        waitForStart();

        while (opModeIsActive()) {

            Color.RGBToHSV((int) (sensorColor.red() * SCALE_FACTOR),
                    (int) (sensorColor.green() * SCALE_FACTOR),
                    (int) (sensorColor.blue() * SCALE_FACTOR),
                    hsvValues);
                    int cube = 0;
                    int red = sensorColor.red();
                    int green = sensorColor.green();
                    int blue = sensorColor.blue();
                    Right.setPower(0);
                    Left.setPower(0);
                    if (red <= 35 && red >= 20){
                        if (green <= 30  && green >= 20) {
                            if (blue <= 21 && blue >= 12) {
                                telemetry.addLine("Cube!");
                              Right.setPower(1);
                              Left.setPower(-1);
                            }
                        
                        }
                    } 
                    
                    
            telemetry.addLine()
              .addData("H", "%.3f", hsvValues[0])
              .addData("S", "%.3f", hsvValues[1])
              .addData("V", "%.3f", hsvValues[2]);
            telemetry.addData("Alpha", sensorColor.alpha());
            telemetry.addData("Red  ", sensorColor.red());
            telemetry.addData("Green", sensorColor.green());
            telemetry.addData("Blue ", sensorColor.blue());
            telemetry.addData("Hue", hsvValues[0]);

            relativeLayout.post(new Runnable() {
                public void run() {
                    relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, values));
                }
            });

            telemetry.update();
        }

    }
}
