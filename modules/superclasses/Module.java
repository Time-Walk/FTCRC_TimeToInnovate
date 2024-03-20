package org.firstinspires.ftc.teamcode.modules.superclasses;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

abstract public class Module {
    public Telemetry telemetry;
    public LinearOpMode L;
    public HardwareMap hwmp;
    public Gamepad gamepad1, gamepad2;
    abstract public void init();
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry; this.L = L; this.hwmp = hwmp;
    }
    public void init_gamepad(Gamepad gamepad1, Gamepad gamepad2) {
        this.gamepad1 = gamepad1; this.gamepad2 = gamepad2;
    }
    public void delay(long millis) { //Вспомогательная функция как sleep, только прекраснее, чудеснее, чудеснее, прекраснее
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
