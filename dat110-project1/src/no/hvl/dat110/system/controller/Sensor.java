package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;
import no.hvl.dat110.system.sensor.SensorImpl;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	private SensorImpl read = new SensorImpl();
	
	public int read() {
		
		int temp;
		
		temp = read.read();
		
		byte[] request = RPCUtils.marshallInteger(RPCID, temp);
		
		byte[] response = rpcclient.call(request);
		
		temp = RPCUtils.unmarshallInteger(response);
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
		return temp;
	}
	
}
