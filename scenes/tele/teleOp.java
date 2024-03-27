package org.firstinspires.ftc.teamcode.scenes.tele;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.func.teleop.DriverHelper;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;


@TeleOp(name="teleOp")
public class teleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        DriverHelper dh = new DriverHelper();
        R.init(telemetry, this, hardwareMap);
        R.gamepad_init(gamepad1, gamepad2);
        dh.initGamepad(gamepad1);
        waitForStart();
        while(!isStopRequested()) {
            dh.dh();
            R.wb.tele();
            R.sm.tele();
            R.grab.tele();
            R.hg.tele();
        }

    }
}