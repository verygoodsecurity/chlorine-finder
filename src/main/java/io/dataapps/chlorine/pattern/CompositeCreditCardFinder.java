/*
 * Copyright 2016, DataApps Corporation (http://dataApps.io) .
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dataapps.chlorine.pattern;

import io.dataapps.chlorine.finder.CompositeFinder;
import io.dataapps.chlorine.finder.Finder;
import io.dataapps.chlorine.finder.FinderResult;

public class CompositeCreditCardFinder implements Finder {

	private CompositeFinder compositeFinder;

	/**
	 * Build a Composite CreditCardFinder using a multiple CreditCardFinders
	 * Each CreditCardFinder has patterns to identify different 
	 * Credit Card types like Visa, MasterCard etc.
	 *
	 */
	public CompositeCreditCardFinder () {
		compositeFinder = new CompositeFinder("CreditCard");
		compositeFinder.add(new CreditCardFinder("Mastercard",  "5[1-5][0-9]{2}(\\ |\\-|)[0-9]{4}(\\ |\\-|)[0-9]{4}(\\ |\\-|)[0-9]{4}"));
		compositeFinder.add(new CreditCardFinder("Visa", "4[0-9]{3}(\\ |\\-|)[0-9]{4}(\\ |\\-|)[0-9]{4}(\\ |\\-|)[0-9]{4}"));
		compositeFinder.add(new CreditCardFinder("AMEX", "(34|37)[0-9]{2}(\\ |\\-|)[0-9]{6}(\\ |\\-|)[0-9]{5}"));
		compositeFinder.add(new CreditCardFinder("Diners Club 1", "30[0-5][0-9](\\ |\\-|)[0-9]{6}(\\ |\\-|)[0-9]{4}"));
		compositeFinder.add(new CreditCardFinder("Diners Club 2", "(36|38)[0-9]{2}(\\ |\\-|)[0-9]{6}(\\ |\\-|)[0-9]{4}"));
		compositeFinder.add(new CreditCardFinder("Discover", "6011(\\ |\\-|)[0-9]{4}(\\ |\\-|)[0-9]{4}(\\ |\\-|)[0-9]{4}"));
		compositeFinder.add(new CreditCardFinder("JCB 1", "3[0-9]{3}(\\ |\\-|)[0-9]{4}(\\ |\\-|)[0-9]{4}(\\ |\\-|)[0-9]{4}"));
		compositeFinder.add(new CreditCardFinder("JCB 2", "(2131|1800)[0-9]{11}"));
	}

	@Override
	public FinderResult find(String sample) {
		return compositeFinder.find(sample);
	}

	@Override
	public String getName() {
		return compositeFinder.getName();
	}

}
