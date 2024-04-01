package org.firstinspires.ftc.teamcode.func.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Config
public class DriverHelper {
    public static double RelePw = .5;
    RobotConstruct R; Gamepad gamepad1;
    int dhPower[];
    int state = 0;
    public void init(RobotConstruct R, Gamepad gamepad1) {
        this.R = R; this.gamepad1 = gamepad1;
        dhPower = new int[4]; state = 0;
    }
    //public int[] tele() {
    //    if ( gamepad1.dpad_left && state == 0 )
    //    return dhPower;
    //}
}
