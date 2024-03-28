package org.firstinspires.ftc.teamcode.scenes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Autonomous(name="TestDigial", group="")
public class TestDigitalChannel extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        waitForStart();

        //okay, let's go!

        R.led.LEDL.setState(true);
        R.led.delay(3000);
        R.led.LEDL.setState(false);
        R.led.delay(3000);
        R.led.LEDL.setState(true);
        R.led.delay(3000);

    }

}
