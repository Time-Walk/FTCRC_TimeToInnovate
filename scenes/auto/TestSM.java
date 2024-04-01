package org.firstinspires.ftc.teamcode.scenes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Autonomous(name="9/11", group="")
public class TestSM extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        waitForStart();

        //okay, let's go!

         R.sm.SMA.setPosition(R.sm.SMAFLY);
         R.sm.delay(1000000000);

    }

}
