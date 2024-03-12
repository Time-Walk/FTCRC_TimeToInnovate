package org.firstinspires.ftc.teamcode.scenes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.func.teleop.GrabTeleop;
import org.firstinspires.ftc.teamcode.func.teleop.WheelBaseDrive;
import org.firstinspires.ftc.teamcode.modules.Drone;
import org.firstinspires.ftc.teamcode.modules.RobotConstruct;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;
import org.firstinspires.ftc.teamcode.func.teleop.driverHelper;



@TeleOp(name="teleOp")
public class teleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.initFields(telemetry, this, hardwareMap);
        R.init();
        R.gamepad_init(gamepad1, gamepad2);
        waitForStart();
        while(!isStopRequested()) {
            R.dh.dh();
            R.wbd.drive();
            R.sm.fly();
            R.grabtele.grab();


        }

    }
}