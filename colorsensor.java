
package org.firstinspires.ftc.robotcontroller.external.samples;

import android.app.Activity;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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
@Autonomous(name = "CubeOrSphere: REVColorDistance", group = "Sensor")
//@Disabled                            // Comment this out to add to the opmode list

public class CubeOrSphere extends LinearOpMode {
    
    ColorSensor sensorColor;
    DcMotor Left, Right;
    public void drive(double x, double y, int z) {
        Left.setPower(x);
        Right.setPower(y);
        sleep(z);
        Left.setPower(0);
        Right.setPower(0);
    }
    
    
    @Override
    public void runOpMode() {

        
        Left  = hardwareMap.dcMotor.get("Left");
        Right = hardwareMap.dcMotor.get("Right");
        Left.setDirection(DcMotor.Direction.REVERSE);
        Right.setDirection(DcMotor.Direction.FORWARD);
        sensorColor = hardwareMap.get(ColorSensor.class, "color_sensor");
        float[] hsvValues = new float[3];
        final float values[] = hsvValues;
        final double SCALE_FACTOR = 255;
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);
        int cube = 0;
        int sphere = 0;
        
        waitForStart();

        while (opModeIsActive()) {
            Color.RGBToHSV((int) (sensorColor.red() * SCALE_FACTOR),
                    (int) (sensorColor.green() * SCALE_FACTOR),
                    (int) (sensorColor.blue() * SCALE_FACTOR),
                    hsvValues);
                    Right.setPower(0);
                    Left.setPower(0);
                    int red = sensorColor.red();
                    int green = sensorColor.green();
                    int blue = sensorColor.blue();
            if (red >= 38 && red <= 50){        
             if (green >= 30  && green <= 42) {
                if (blue >= 18 && blue <= 25) {
                    cube = 1;
                    drive(1, 1, 200);
                   }
                 
             }} else {
                 cube = 0;
             }
             
             if (red >= 80 && red <= 140){        
             if (green >= 85  && green <= 130) {
                if (blue >= 70 && blue <= 120) {
                    sphere = 1;
                    drive(-1, -1, 200);
                    drive(.1, .1, 10);
                    sleep(50);
                    drive(1, 0, 900);
                    drive(-.1, 0, 100);
                   }
                 
             }} else {
                 sphere = 0;
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
            if (cube == 1) {
                telemetry.addLine("Cube!");
            } else if (sphere == 1) {
                telemetry.addLine("Sphere");
            }
            
         
            relativeLayout.post(new Runnable() {
                public void run() {
                    relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, values));
                }
            });

            telemetry.update();

                    }}}



