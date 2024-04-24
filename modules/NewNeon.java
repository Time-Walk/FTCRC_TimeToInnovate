package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

@Config
public class NewNeon extends Module {
    public DigitalChannel LEDL;
    DigitalChannel LEDR;
    public static int LED_COUNT_L = 24, LED_COUNT_R = 24;
    public int[][] LedL, LedR;
    boolean _send = false;
    public void init() {
        LEDL = hwmp.get(DigitalChannel.class, "LEDL");
        LEDL.setMode(DigitalChannel.Mode.OUTPUT);
        LEDR = hwmp.get(DigitalChannel.class, "LEDR");
        LEDR.setMode(DigitalChannel.Mode.OUTPUT);
        LedL = new int[LED_COUNT_L][3];
        LedR = new int[LED_COUNT_R][3];
        telemetry.addData("led", "inited");
        telemetry.update();
        for (int i=0; i<LED_COUNT_L; i++) {
            LedL[i][0] = 170;
            LedL[i][1] = 128;
            LedL[i][2] = 255;
        }
        for (int i=0; i<LED_COUNT_R; i++) {
            LedR[i][0] = 170;
            LedR[i][1] = 128;
            LedR[i][2] = 255;
        }
        Sender.run();
        _send = true;
    }

    public void send() { _send = true; }

    public Thread setChnlTrue = new Thread() {
        @Override
        public void run() {
            LEDL.setState(true);
        }
    };

    public Thread setChnlFalse = new Thread() {
        @Override
        public void run() {
            LEDL.setState(false);
        }
    };

    public Thread Sender = new Thread() {
        void setState(DigitalChannel channel, char state) {
            if ( state == '1' ) {
                //channel.setState(true);
                //telemetry.addData("setToTrue1", System.nanoTime());
                setChnlTrue.run();
                advancedDelay(0, 800);
                //channel.setState(false);
                //telemetry.addData("setToFalse1", System.nanoTime());
                setChnlFalse.run();
                advancedDelay(0, 450);
                //channel.setState(true);
                //telemetry.addData("realese1", System.nanoTime());
                setChnlTrue.run();
            }
            else {
                //channel.setState(true);
                //telemetry.addData("setToTrue0", System.nanoTime());
                setChnlTrue.run();
                advancedDelay(0, 400);
                //channel.setState(false);
                //telemetry.addData("setToFalse0", System.nanoTime());
                setChnlFalse.run();
                advancedDelay(0, 850);
                //channel.setState(true);
                //telemetry.addData("realese0", System.nanoTime());
                setChnlTrue.run();
            }
        }
        @Override
        public void run() {
            while ( !L.opModeIsActive() && !L.isStopRequested() ) {
                //telemetry.addData("_send", _send);
                //telemetry.update();
                if ( !_send ) {
                    //telemetry.addData("sender", "sending");
                    //telemetry.update();
                    _send = false;
                    for (int i=0; i<LedL.length; i++) {
                        String GColorBased = Integer.toBinaryString(LedL[i][1]);
                        String RColorBased = Integer.toBinaryString(LedL[i][0]);
                        String BColorBased = Integer.toBinaryString(LedL[i][2]);

                        telemetry.addData("GColorBased", GColorBased);
                        telemetry.addData("RColorBased", RColorBased);
                        telemetry.addData("BcolorBased", BColorBased);
                        //telemetry.update();
                        setState(LEDL, GColorBased.charAt(7));
                        setState(LEDL, GColorBased.charAt(6));
                        setState(LEDL, GColorBased.charAt(5));
                        setState(LEDL, GColorBased.charAt(4));
                        setState(LEDL, GColorBased.charAt(3));
                        setState(LEDL, GColorBased.charAt(2));
                        setState(LEDL, GColorBased.charAt(1));
                        setState(LEDL, GColorBased.charAt(0));
                        setState(LEDL, RColorBased.charAt(7));
                        setState(LEDL, RColorBased.charAt(6));
                        setState(LEDL, RColorBased.charAt(5));
                        setState(LEDL, RColorBased.charAt(4));
                        setState(LEDL, RColorBased.charAt(3));
                        setState(LEDL, RColorBased.charAt(2));
                        setState(LEDL, RColorBased.charAt(1));
                        setState(LEDL, RColorBased.charAt(0));
                        setState(LEDL, BColorBased.charAt(7));
                        setState(LEDL, BColorBased.charAt(6));
                        setState(LEDL, BColorBased.charAt(5));
                        setState(LEDL, BColorBased.charAt(4));
                        setState(LEDL, BColorBased.charAt(3));
                        setState(LEDL, BColorBased.charAt(2));
                        setState(LEDL, BColorBased.charAt(1));
                        setState(LEDL, BColorBased.charAt(0));

                        telemetry.update();


                        advancedDelay(0, 50000);

                    }
                    /*for (int i=0; i<LedR.length; i++) {
                        char[] GColorBased = Integer.toBinaryString(LedR[i][1]).toCharArray();
                        char[] RColorBased = Integer.toBinaryString(LedR[i][0]).toCharArray();
                        char[] BColorBased = Integer.toBinaryString(LedR[i][2]).toCharArray();

                        setState(LEDR, GColorBased[7]);
                        setState(LEDR, GColorBased[6]);
                        setState(LEDR, GColorBased[5]);
                        setState(LEDR, GColorBased[4]);
                        setState(LEDR, GColorBased[3]);
                        setState(LEDR, GColorBased[2]);
                        setState(LEDR, GColorBased[1]);
                        setState(LEDR, GColorBased[0]);
                        setState(LEDR, RColorBased[7]);
                        setState(LEDR, RColorBased[6]);
                        setState(LEDR, RColorBased[5]);
                        setState(LEDR, RColorBased[4]);
                        setState(LEDR, RColorBased[3]);
                        setState(LEDR, RColorBased[2]);
                        setState(LEDR, RColorBased[1]);
                        setState(LEDR, RColorBased[0]);
                        setState(LEDR, BColorBased[7]);
                        setState(LEDR, BColorBased[6]);
                        setState(LEDR, BColorBased[5]);
                        setState(LEDR, BColorBased[4]);
                        setState(LEDR, BColorBased[3]);
                        setState(LEDR, BColorBased[2]);
                        setState(LEDR, BColorBased[1]);
                        setState(LEDR, BColorBased[0]);

                        advancedDelay(0, 50000);

                    }*/
                    advancedDelay(0, 100000);
                }
            }
        }
    };
}
