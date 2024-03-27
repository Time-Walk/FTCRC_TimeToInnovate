package org.firstinspires.ftc.teamcode.modules.superclasses;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.func.classes.RR;
import org.firstinspires.ftc.teamcode.func.teleop.DriverHelper;
import org.firstinspires.ftc.teamcode.modules.Drone;
import org.firstinspires.ftc.teamcode.modules.Grab;
import org.firstinspires.ftc.teamcode.modules.Hanging;
import org.firstinspires.ftc.teamcode.modules.IMU;
import org.firstinspires.ftc.teamcode.modules.Neon;
import org.firstinspires.ftc.teamcode.modules.NewNeon;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;
import org.firstinspires.ftc.teamcode.modules.camera.CameraOut;

@Config
public class RobotConstruct {
    public CameraOut cameraOut; // создание переменнгой камеры
    public Wheelbase wb; // переменная колсной базы
    public Drone sm;// переменная для самолётика
    public Neon neon; // переменная для светоленты
    public Grab grab;// переменная механихма захвата
    public IMU imu;//
    //public RPD rpd;
    //public RR rr;
    public Hanging hg;
    public NewNeon led;
    //public DriverHelper dh;
    public Telemetry telemetry;
    public Gamepad gamepad1, gamepad2;
    public LinearOpMode L;
    public HardwareMap hwmp;

    public void init(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {

        this.telemetry = telemetry;
        this.L = L;
        this.hwmp = hwmp;

        //cameraOut = new CameraOut();
        //cameraOut.initFields(telemetry, L, hwmp);
        //cameraOut.init();

        wb = new Wheelbase();
        wb.initFields(telemetry, L, hwmp);
        wb.init();

        //sm = new Drone();
        //sm.initFields(telemetry, L, hwmp);
        //sm.init();

        //neon = new Neon();
        //neon.initFields(telemetry, L, hwmp);
        //neon.init();

       /* grab = new Grab();
        grab.initFields(telemetry, L, hwmp);
        grab.init();*/

        imu = new IMU();
        imu.initFields(telemetry, L, hwmp);
        imu.init();

        //hg = new Hanging();
        //hg.initFields(telemetry, L, hwmp);
        //hg.init();

        led = new NewNeon();
        led.initFields(telemetry, L, hwmp);
        led.init();
    }

    public void gamepad_init(Gamepad gamepad1, Gamepad gamepad2) {
        wb.init_gamepad(gamepad1, gamepad2);
        sm.init_gamepad(gamepad1, gamepad2);
        grab.init_gamepad(gamepad1, gamepad2);
        hg.init_gamepad(gamepad1, gamepad2);
        led.init_gamepad(gamepad1, gamepad2);
    }

}
