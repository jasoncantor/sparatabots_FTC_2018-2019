package org.firstinspires;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="NerfBot", group="Linear Opmode")

public class NerfBotL extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftright = null;
    private DcMotor updown = null;
    private Servo servo1;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftright  = hardwareMap.get(DcMotor.class, "leftright");
        updown = hardwareMap.get(DcMotor.class, "updown");
        servo1 = hardwareMap.get(Servo.class, "servo");
        

        leftright.setDirection(DcMotor.Direction.FORWARD);
        updown.setDirection(DcMotor.Direction.REVERSE);
        
        

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            
            double updownPower;
            double leftrightPower;

        /*    double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
        */
            
            double updownMotor = -gamepad1.left_stick_y;
            double leftrightMotor  =  gamepad1.right_stick_x;
            updownPower    = Range.clip(updownMotor, -.5, .5) ;
            leftrightPower   = Range.clip(leftrightMotor, -.2, .2) ;
            
            
            if (gamepad1.a) {
                servo1.setPosition(0);
            } else if (!gamepad1.a) {
                servo1.setPosition(.5);
                
            }

            updown.setPower(updownPower);
            leftright.setPower(leftrightPower);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "leftright (%.2f), updown (%.2f)", leftrightPower, updownPower);
            telemetry.update();
        }
    }
}
