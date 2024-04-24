package org.firstinspires.ftc.teamcode.scenes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Autonomous(name="TestLEDGreen", group="")
public class TestLEDGreen extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        waitForStart();

        //okay, let's go!

            R.led.LedL[23][0] = 10;
            R.led.LedL[23][1] = 201;
            R.led.LedL[23][2] = 11;
            R.led.send();
            R.led.delay(500);

    }

}
