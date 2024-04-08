package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Feeder {
    private final TalonFX motor;
   
    public Feeder() {
        motor = new TalonFX(RobotConstants.feederMotorID);
        motor.clearStickyFaults();
        motor.setNeutralMode(NeutralModeValue.Coast);
   }

   public void feed() {
        motor.set(-RobotConstants.feederMotorSpeed);
   }

   public void feedSlow() {
        motor.set(-RobotConstants.feederMotorSpeed / 3);
   }
   public void reverse() {
        motor.set(RobotConstants.feederMotorSpeed);
   }

   public void stop(){
        motor.set(0);
   }

   public void fullPow(){
     motor.set(-1);
   }

public void assist() {
     if(Robot.irBreak.get()) {
     motor.set(-RobotConstants.feederAssistMotorSpeed);
     }
     else{
          stop();
     }
}

}
