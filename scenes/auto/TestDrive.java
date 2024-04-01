package org.firstinspires.ftc.teamcode.scenes.auto;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.func.classes.DRP;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Config
@Autonomous(name="TestDrive", group="")
public class TestDrive extends LinearOpMode {
    public static double x = 2000;
    public static double y = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        Telemetry dtelemetry = FtcDashboard.getInstance().getTelemetry();
        dtelemetry.addData("Ux", 0);
        dtelemetry.addData("Uy", 0);
        dtelemetry.addData("Urot", 0);
        dtelemetry.addData("lf", 0);
        dtelemetry.addData("lb", 0);
        dtelemetry.addData("rf", 0);
        dtelemetry.addData("rb", 0);
        dtelemetry.addData("ErX", 0);
        dtelemetry.addData("ErY", 0);
        dtelemetry.update();
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        DRP drp = new DRP();
        drp.init(R, this);
        waitForStart();

        //okay, let's go!
        drp.go(x, 0);
        R.ap.delay(1000);
        drp.go(0, y);

    }

}
