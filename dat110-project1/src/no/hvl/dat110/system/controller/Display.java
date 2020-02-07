package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;
import no.hvl.dat110.system.display.DisplayImpl;

public class Display extends RPCStub {

	private byte RPCID = 1;
	
	private DisplayImpl impl = new DisplayImpl();

	public void write(String message) {
		
		byte [] melding = RPCUtils.marshallString(RPCID, message);
		
		byte [] sender = rpcclient.call(melding);
		
		impl.write(RPCUtils.unmarshallString(sender));
		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
	}
}
