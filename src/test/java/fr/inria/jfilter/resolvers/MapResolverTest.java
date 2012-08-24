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
package fr.inria.jfilter.resolvers;

import junit.framework.Test;
import junit.framework.TestSuite;
import fr.inria.jfilter.FilterTestCase;

/**
 * Unit test for Bean Resolver class.
 */
public class MapResolverTest extends FilterTestCase {
	public MapResolverTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(MapResolverTest.class);
	}

	public void testResolveUnknownKey() {
		assertEmpty(MapResolver.map.getValue(map, "abc"));
	}

	public void testResolveMapWithString() {
		assertContains(bean.firstname,
				MapResolver.map.getValue(map, "firstname"));
	}

	public void testResolveMapWithInt() {
		assertContains(bean.age, MapResolver.map.getValue(map, "age"));
	}

	public void testResolveMapWithDouble() {
		assertContains(bean.height, MapResolver.map.getValue(map, "height"));
	}

	public void testResolveMapWithBoolean() {
		assertContains(bean.male, MapResolver.map.getValue(map, "male"));
	}

	public void testResolveMapWithObject() {
		assertContains(bean.home, MapResolver.map.getValue(map, "home"));
	}

	public void testResolvePropertiesWithString() {
		assertContains(bean.firstname,
				MapResolver.map.getValue(property, "firstname"));
	}
}