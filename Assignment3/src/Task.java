public abstract class Task implements Runnable {
	String task_name;
	boolean isFinished;

	public Task(String task_name) {
		this.task_name = task_name;		// task name
		this.isFinished = false;
	}

	public String getName() {		// get name method
		return task_name;
	}
  
	public boolean getIsFinished() {
		return isFinished;
	}
  
	public void setIsFinished() {
		isFinished = true;
	}
}