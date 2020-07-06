FluidNormalize : FluidManipulationClient {

  *new {|server, min = 0, max = 1|
		var uid = UniqueID.next;
		^super.new(server,min,max,uid)!?{|inst|inst.init(uid);inst}
	}

	init {|uid|
		id = uid;
	}

	fit{|dataset, action|
		this.prSendMsg(\fit,[dataset.asSymbol], action);
	}

	transform{|sourceDataset, destDataset, action|
		this.prSendMsg(\transform,
			[sourceDataset.asSymbol, destDataset.asSymbol], action
		);
	}

	fitTransform{|sourceDataset, destDataset, action|
		this.prSendMsg(\fitTransform,
			[sourceDataset.asSymbol, destDataset.asSymbol], action
		);
	}

	transformPoint{|sourceBuffer, destBuffer, action|
		this.prSendMsg(\transformPoint,
			[sourceBuffer.asUGenInput, destBuffer.asUGenInput], action
		);
	}
}
