package vn.topica.sf18.test.facebook; /**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 * <p>
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 * <p>
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import com.facebook.ads.sdk.*;

public class PagingExample {
    public static final String ACCESS_TOKEN = "EAALGrsZCwK40BAKHKETlK38EKrr3nlzit0f6xlSRfTutb9aGkyK1VReZC1HAZB1s4zg6PJv1LRcdoXm7w6PjmnwM6SNLaVyTCbBWX5kB2dp6TKqxJj0pMxQITLywWKZBea6bWwjxPZAPVRBIcgCUwkk1ZCTqhjHXW1xZBPZAN3c0jIAxZA5oqlnyK";
    public static final String APP_SECRET = "5efbc5ec7c0f4cd4ebd2a95aaca8636f";
    public static final Long ACCOUNT_ID = 999471790118129L;
    public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(false);

    public static void main(String[] args) throws APIException {
        AdAccount account = new AdAccount(ACCOUNT_ID, context);
        APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
        while (campaigns != null) {
            for (Campaign campaign : campaigns) {
                System.out.println(campaign);
            }
            campaigns = campaigns.nextPage();
        }
    }
}
