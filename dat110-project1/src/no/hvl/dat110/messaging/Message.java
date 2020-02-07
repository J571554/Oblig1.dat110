package no.hvl.dat110.messaging;

public class Message {

	private byte[] payload;

	public Message(byte[] payload){
		if(payload.length >= MessageConfig.SEGMENTSIZE) {
			payload = null;
		}
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = null;
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		int size = MessageConfig.SEGMENTSIZE;
		encoded = new byte[size];
		int messagesize = payload.length;
		encoded[0] = (byte) messagesize;
		for (int i = 0; i < messagesize; i ++) {
			encoded[i+1] = payload[i];
		}
	
		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		payload = new byte[received[0]];
		int size = payload.length;
		for (int i = 0; i < size; i++) {
			payload[i] = received[i+1];
		}
	}
}
