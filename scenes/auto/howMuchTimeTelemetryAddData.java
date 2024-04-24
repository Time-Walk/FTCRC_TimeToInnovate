package org.firstinspires.ftc.teamcode.scenes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Autonomous(name="проф замеры", group="")
public class howMuchTimeTelemetryAddData extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        waitForStart();

        //okay, let's go!

        R.led.LEDL.setState(true);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(false);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(true);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(false);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(true);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(false);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(true);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(false);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(true);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(false);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(true);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(false);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(true);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(false);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(true);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(false);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(true);
        telemetry.addData("a", System.nanoTime());
        R.led.LEDL.setState(false);
        telemetry.addData("a", System.nanoTime());
        telemetry.update();
        R.led.delay(30000);

    }

}
