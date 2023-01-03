//goofy code that may or may not be functional
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMAX.ControlType;
import com.CANSparkMaxLowLevel.MotorType;

public class Robot {
    private DifferentialDrive m_myRobot;
    private CANSparkMax m_leftMotor1;
    private CANSparkMax m_leftMotor2;
    private CANSparkMax m_rightMotor1;
    private CANSparkMax m_rightMotor2;

    private Timer m_timer;

    public void initializeRobot() {
        //setting up arcade drive
        m_leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
        m_leftMotor2 = new CANSparkMax(2, MotorType.kBrushless);
        m_rightMotor1 = new CANSparkMax(3, MotorType.kBrushless);
        m_rightMotor3 = new CANSparkMax(4, MotorType.kBrushless);

        m_leftMotor1.restoreFactoryDefaults();
        m_leftMotor2.restoreFactoryDefaults();
        m_rightMotor1.restoreFactoryDefaults();
        m_rightMotor2.restoreFactoryDefaults();

        m_leftMotor1.setInverted(true);
        m_leftMotor2.setInverted(true);

        MotorControllerGroup m_left = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
        MotorControllerGroup m_right = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);
        m_myRobot = new DifferentialDrive(m_left, m_right);
    }

    public void goRobot() {
        //start new timer
        m_timer = new Timer();
        m_timer.reset();
        m_timer.start();

        //robot go forward for 3 seconds
        while (m_timer.get() < 3.0) m_myRobot.arcadeDrive(3,0);
        //turn and move for 3 seconds
        while (m_timer.get() > 3.0 && m_timer.get() < 6.0) m_myRobot.arcadeDrive(3,1);
        //turn other way and move for 3 seconds
        while (m_timer.get() > 6.0 && m_timer.get() < 9.0) m_myRobot.arcadeDrive(3,-1);
        m_myRobot.stopMotor();
    }
}