public class Robot {
	// Default speed for all robot actions. Can be multiplied by floats for fine
	// tuning.
	public int defaultSpeed = 4;
	// Inits
	private DifferentialDrive driveController;
	private CANSparkMax m_leftMotor1;
	private CANSparkMax m_leftMotor2;
	private CANSparkMax m_rightMotor1;
	private CANSparkMax m_rightMotor2;

	public void initializeRobot() {
		m_leftMotor1.setInverted(true);
		m_leftMotor2.setInverted(true);
	}

	// This path will be called during an autonomous period.
	public void arcadeDriveAuto() {
		private arcadeTimer = new Timer();
		arcadeTimer.reset();
		arcadeTimer.start();
		while (arcadeTimer.get() < 4.0) {
			// Drives the robot forward for four seconds.
			driveController.arcadeDrive(defaultSpeed,0);
		}
		while (arcadeTimer.get() > 4.0 && arcadeTimer.get() < 10.0) {
			// Turns the robot (and drives) for 6 seconds.
			driveController.arcadeDrive(defaultSpeed*4,1);
		}
	}
}
