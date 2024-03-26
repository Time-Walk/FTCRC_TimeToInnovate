package org.firstinspires.ftc.teamcode.scenes.auto;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.func.classes.DRP;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Config
@Autonomous(name="TestDrive", group="")
public class TestDrive extends LinearOpMode {
    public static double x = 0;
    public static double y = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        waitForStart();

        //okay, let's go!

        DRP drp = new DRP();
        drp.init(R);
        drp.go(x, y);

    }

}
