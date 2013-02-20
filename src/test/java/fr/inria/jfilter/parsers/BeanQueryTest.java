/**
 * Copyright (C) 2012 University Lille 1, Inria
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA  02110-1301, USA.
 *
 * Contact: romain.rouvoy@univ-lille1.fr
 */
package fr.inria.jfilter.parsers;

import static fr.inria.jfilter.parsers.BeanQueryParser.bean;

import java.util.Collection;

import junit.framework.Test;
import junit.framework.TestSuite;
import fr.inria.jfilter.FilterTestCase;
import fr.inria.jfilter.ParsingException;
import fr.inria.jfilter.Query;

public class BeanQueryTest extends FilterTestCase {
	public BeanQueryTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(BeanQueryTest.class);
	}

	public void testSimplePath() throws ParsingException {
		Query query = bean.parse("members(firstname=John)");
		
		Collection<Object> res = query.apply(doe);
		assertFalse(res.isEmpty());
		assertSize(1, res);
		assertContains(doe.dad, res);
	}

	public void testDeepPath() throws ParsingException {
		Query query = bean
				.parse("members(lastname=Doe).address(postcode=10014)");
		Collection<Object> res = query.apply(doe);
		assertFalse(res.isEmpty());
		assertSize(1, res);
		assertContains(doe.dad.address, res);
	}

	public void testComplexPath() throws ParsingException {
		Query query = bean.parse("members.address(postcode=10014).country");
		Collection<Object> res = query.apply(doe);
		assertFalse(res.isEmpty());
		assertSize(1, res);
		assertContains(doe.dad.address.country(), res);
	}
}
