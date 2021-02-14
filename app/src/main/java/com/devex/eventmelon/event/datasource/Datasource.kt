package com.devex.eventmelon.event.datasource

import com.devex.eventmelon.R
import com.devex.eventmelon.home.model.HomeCard
import com.devex.eventmelon.model.Event

class Datasource {
    fun loadEvents(): List<Event> {
        return listOf<Event>(
            Event(
                id = "10",
                name = "Android Study Jam: Kotlin Fundamentals",
                date = "From Thursday, September 23, 2020 to Monday, September 31, 2020",
                host = "GDSC MBCET",
                price = 0,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/WhatsApp%20Image%202021-02-12%20at%2015.39.39.jpeg?alt=media&token=5b500e6d-e287-4217-90d6-f628b027d941",
                description = "We are excited to bring you the second session of our Android Study Jam. We will cover the following topics in Kotlin during the session..."
            ),
            Event(
                id = "1",
                name = "Hackathon",
                date = "From Thursday, November 14, 2021 to Friday, November 15, 2021",
                host = "Entrepreneurship Center, Atlanta GA",
                price = 0,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/optimized_large_thumb_stage.jpg?alt=media&token=d9f53eaf-c31b-4010-8685-b48461cc323f",
                description = "We are immensely proud and happy to present before you our very first virtual hackathon event . Along with this we have fun activities coming up....."
            ),
            Event(
                id = "2",
                name = "Crack the Code",
                date = "From Monday 20th August to Tuesday 21st August 2021 ",
                host = "Govt Engineering College, Bengaluru",
                price = 0,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/large_775433_oya_8az77qbkv_hckp6rxd9hc.png?alt=media&token=f798b418-d9c8-4dfe-ad51-0e7a8f937069",
                description = "We are happy to announce that our hackathon Crack the code has opened their registration. We welcome all the coders to come and join us in this venture....."
            ),
            Event(
                id = "3",
                name = "CODE4MUNNAR",
                date = "January 29,30,31 2021 ",
                host = "Govt Engineering College, Munnar",
                price = 0,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/WhatsApp%20Image%202021-02-12%20at%2014.27.37%20(1).jpeg?alt=media&token=7ed57ac5-9807-4d0e-b276-b5dbc9bc9c45",
                description = "We present before you our flagship event of this year CODE4MUNNAR. A platform to present your ideas to solve our day to day problems.. to make our lives much easier......"
            ),
            Event(
                id = "4",
                name = "BEST ENGINEER",
                date = "February  4,5 2021 ",
                host = "Mar Athenesius College of Engineering",
                price = 0,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/WhatsApp%20Image%202021-02-12%20at%2014.27.39.jpeg?alt=media&token=88cfec44-a6b9-49bb-80c7-b9f67087feca",
                description = "Takshak 2021 presents the BEST ENGINEER program.  On February 4 and 5 there will be three exciting unique rounds of competition to find the best , innovative and creative engineer......"
            ),
            Event(
                id = "5",
                name = "Awareness on OSM MAPPING",
                date = "January 9 2021 ",
                host = "Mar Baselios College of Engineering and Technology",
                price = 0,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/WhatsApp%20Image%202021-02-12%20at%2014.43.25.jpeg?alt=media&token=fb541f1f-2300-4b71-bf3f-25c3eed7d945",
                description = "NSS MBCET UNIT  is conducting an awareness on OSM Mapping .  On 9th of January , a 2 he session on the  importance of OSM MAPPING......"
            ),
            Event(
                id = "6",
                name = "Deep dive into OPEN SOURCE with Santosh Yadav",
                date = "28th November 2020",
                host = " DSC MBCET",
                price = 0,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/WhatsApp%20Image%202021-02-12%20at%2014.47.45%20(1).jpeg?alt=media&token=8667d269-ba34-4213-8980-daf7daf21c0f",
                description = "DSC MBCET UNIT  is happy to announce a webinar conducted by Santosh Yadav on deep dive into Open Source. Santosh Yadav is a Google Developer Expert and a Github Star. We welcome everyone to attend this event ......."
            ),
            Event(
                id = "7",
                name = "Overview on IEEE PES",
                date = "30th January 2021",
                host = " IEEE PES SBC MBCET",
                price = 0,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/WhatsApp%20Image%202021-02-12%20at%2014.47.45%20(2).jpeg?alt=media&token=eaded55f-c59f-4af3-93b7-9e4e5b219340",
                description = "IEEE PES SBC MBCET presents webinar on IEEE Power and Energy Society. This webinar is handled by  Suhair A K ,Chair of IEEE PES Kerala Chapter........"
            ),
            Event(
                id = "8",
                name = "ANGULAR 101",
                date = " November 4,5,6,9 2021",
                host = " IEEE CS  MBCET",
                price = 0,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/WhatsApp%20Image%202021-02-12%20at%2014.47.45.jpeg?alt=media&token=62a3d13e-d3af-4361-88df-daff307c7247",
                description = "IEEE CS Society presents ANGULAR 101, a 7 day Bootcamp on Angular. This webinar is handled by  Mr Rigin Oomen ,Software Engineer,Red Hat........."
            ),
            Event(
                id = "9",
                name = "CODE.EXE",
                date = " 16th of January 12.00 pm to 17th of January 12.00pm ",
                host = " IEEE Societies,  MBCET",
                price = 0,
                imageUrl ="https://firebasestorage.googleapis.com/v0/b/event-melon.appspot.com/o/WhatsApp%20Image%202021-02-12%20at%2015.17.27.jpeg?alt=media&token=98c64baa-59d1-40c2-98f6-b712bffcd1f3",
                description = "IEEE  Societies presents CODE.EXE, a coding competition. Winners will get prizez worth 1.5K. Do join........."
            )
            /**
             * add your events here in the above format
             */
        )
    }
}