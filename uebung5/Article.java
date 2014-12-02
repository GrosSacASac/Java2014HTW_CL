
		assert number.toString().length() == 4 : "Needs to be 4-digits positive long number";
		try {
			Integer.parseInt(number,10);
		} catch (NumberFormatException e) {
			assert false : "Needs to be 4-digits positive long number";
		}