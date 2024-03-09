package org.firstinspires.ftc.teamcode.func.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;

public class WheelBaseDrive {
    Telemetry telemetry;
    LinearOpMode L;
    HardwareMap hwmp;
    Gamepad gamepad1;
    Wheelbase wb;
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry;
        this.L = L;
        this.hwmp = hwmp;
    }
    public void initGamepad(Gamepad gamepad1) {
        this.gamepad1 = gamepad1;
    }
    public void init() {
        wb = new Wheelbase();
        wb.initFields(telemetry, L, hwmp);
        wb.init();
        }
        public void drive() {
            double rf = gamepad1.left_stick_y + gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.6) - (gamepad1.left_trigger * 0.6) + (gamepad1.right_trigger * 0.6);
            double rb = gamepad1.left_stick_y - gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.6) - (gamepad1.left_trigger * 0.6) + (gamepad1.right_trigger * 0.6);
            double lf = -gamepad1.left_stick_y + gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.6) - (gamepad1.left_trigger * 0.6) + (gamepad1.right_trigger * 0.6);
            double lb = -gamepad1.left_stick_y - gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.6) - (gamepad1.left_trigger * 0.6) + (gamepad1.right_trigger * 0.6);
            wb.setMtPower(lf, lb, rf, rb);
        }
    }

