/*
Copyright (c) 2007-2011, Yusuke Yamamoto
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the Yusuke Yamamoto nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY Yusuke Yamamoto ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Yusuke Yamamoto BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package twitter4j.examples.geo;

import twitter4j.GeoLocation;
import twitter4j.Place;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Creates a place.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class CreatePlace {
    /**
     * Usage: java twitter4j.examples.geo.CreatePlace [name] [contained within] [token] [lat] [long] [street address]
     *
     * @param args message
     */
    public static void main(String[] args) {
        if (args.length < 5) {
            System.out.println("Usage: java twitter4j.examples.geo.CreatePlace [name] [contained within] [token] [lat] [long] [street address]");
            System.exit(-1);
        }
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            String name = args[0];
            String containedWithin = args[1];
            String token = args[2];
            GeoLocation location = new GeoLocation(Double.parseDouble(args[3]), Double.parseDouble(args[4]));
            String streetAddress = null;
            if (args.length >= 6) {
                streetAddress = args[5];
            }
            Place place = twitter.createPlace(name, containedWithin, token, location, streetAddress);
            System.out.println("Successfully created a place [" + place.toString() + "].");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to create a place: " + te.getMessage());
            System.exit(-1);
        }
    }
}
