
public abstract class DocumentItem {
	private boolean lock;
	
	public DocumentItem() {
		this.lock = false;
	}

	public DocumentItem(boolean lock) {
		this.lock = lock;
	}
	
	public boolean isLocked() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}
	
	public abstract String getText();
	public abstract void update(DocumentItem other) throws ModifyingLockedDocumentException;
	
	public int charactersCount() {
		return getText().length();
	}
		
	
	
}