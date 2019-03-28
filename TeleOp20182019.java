package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="TeleOp 2018-2019 (USE THIS)", group="Linear Opmode")
public class TeleOp20182019 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor Lift1 = null;
    private DcMotor shoulderDrive = null;
    private DcMotor extender = null;
    private Servo servo1, servo2;
    int armUp;
    int armDown;
    
    @Override
    public void runOpMode() {
        Boolean button0, button1, button2;
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive  = hardwareMap.get(DcMotor.class, "left");
        rightDrive = hardwareMap.get(DcMotor.class, "right");
        Lift1 = hardwareMap.get(DcMotor.class, "Lift");
        extender = hardwareMap.get(DcMotor.class, "Extender");
        shoulderDrive = hardwareMap.get(DcMotor.class, "Shoulder");
        servo1 = hardwareMap.get(Servo.class, "Servo1");
        servo2 = hardwareMap.get(Servo.class, "Servo2"); 
        
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
      
            double leftPower;
            double rightPower;
            double Arm1Power;
            double shoulderPower;
            double extenderPower;
            double power;
            
            double drive = -gamepad1.left_stick_y;
            double drive2 = -gamepad2.left_stick_y;
            double extenderTurn = gamepad2.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            double shoulderTurn = gamepad2.right_stick_y;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0);
            rightPower   = Range.clip(drive - turn, -1.0, 1.0);
            shoulderPower   = Range.clip(shoulderTurn, -.7, .7);
            extenderPower = Range.clip(extenderTurn, -.5, .5);
   
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
            shoulderDrive.setPower(shoulderPower);
            extender.setPower(extenderPower);
            
            if (button0 = true) {
                Lift1.setPower(0);
            }
            if (gamepad2.dpad_down) {
                Lift1.setPower(-1);
                button0 = true;
            }
            if (gamepad2.dpad_up) {
                Lift1.setPower(1);
                button0 = true;
            }
            if (gamepad2.b) {
                servo1.setPosition(-.5);
                servo2.setPosition(.5);
            }
            if (gamepad2.a) {
                servo1.setPosition(.7);
                servo2.setPosition(-.3);
            }
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f), extender (%.2f), shoulder (%.2f)", leftPower, rightPower, extenderPower, shoulderPower);
            telemetry.update();
        }
    }
}
