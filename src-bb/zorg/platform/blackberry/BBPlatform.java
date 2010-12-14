/**
 * ZRTP.org is a ZRTP protocol implementation  
 * Copyright (C) 2010 - PrivateWave Italia S.p.A.
 * 
 * This  program  is free software:  you can  redistribute it and/or
 * modify  it  under  the terms  of  the  GNU Affero  General Public
 * License  as  published  by the  Free Software Foundation,  either 
 * version 3 of the License,  or (at your option) any later version.
 * 
 * This program is  distributed in  the hope that it will be useful,
 * but WITHOUT ANY WARRANTY;  without even  the implied  warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
 * Affero General Public License for more details.
 * 
 * You should have received a copy of the  GNU Affero General Public
 * License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 * 
 * For more information, please contact PrivateWave Italia S.p.A. at
 * address zorg@privatewave.com or http://www.privatewave.com 
 */
package zorg.platform.blackberry;

import zorg.platform.AddressBook;
import zorg.platform.CryptoUtils;
import zorg.platform.PersistentHashtable;
import zorg.platform.Platform;
import zorg.platform.Utils;
import zorg.platform.ZrtpLogger;

import com.privategsm.main.BuildSettings;

public class BBPlatform implements Platform {

	private static Platform instance = new BBPlatform();
	private final ZrtpLogger logger = new BBLogger();
	private final AddressBook ab    = new BBAddressBook();
	private final BBCryptoUtils cu = new BBCryptoUtils();
	private final BBByteUtils bu = new BBByteUtils();
	
	public static Platform getPlatform() {
		return instance;
	}
	
	public ZrtpLogger getLogger() {
		return logger;
	}
	
	public AddressBook getAddressBook() {
		return ab;
	}

	public boolean isDebugVersion() {
	    return BuildSettings.DEBUG;
    }

	public Utils getUtils() {
	    return bu;
    }

	public CryptoUtils getCrypto() {
	    return cu;
    }

	public PersistentHashtable getHashtable() {
	    return new HashtableAdapter();
    }
}
