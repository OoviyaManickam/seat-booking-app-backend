package com.seat.event.prerequisites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seat.event.dto.EventDto;
import com.seat.event.service.EventService;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component
public class PopulateTables {

    @Autowired
    private EventService service;

    public void initializeTestEvents() {
        // Add test events
        List<EventDto> testEvents = new ArrayList<>();

        EventDto event1 = new EventDto();
        event1.setCategoryName("movie");
        event1.setLanguage("English");
        event1.setTitle("Deadpool & Wolverine");
        event1.setGenre("Superhero");
        event1.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event1.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event1.setVenueName("Forum Mall");
        event1.setLocation("Chennai");
        event1.setDate(Date.valueOf("2024-08-31"));
        event1.setTime(Time.valueOf("11:00:00"));
        testEvents.add(event1);

        EventDto event2 = new EventDto();
        event2.setCategoryName("movie");
        event2.setLanguage("English");
        event2.setTitle("Deadpool & Wolverine");
        event2.setGenre("Superhero");
        event2.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event2.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event2.setVenueName("Forum Mall");
        event2.setLocation("Chennai");
        event2.setDate(Date.valueOf("2024-08-31"));
        event2.setTime(Time.valueOf("17:00:00"));
        testEvents.add(event2);

        EventDto event3 = new EventDto();
        event3.setCategoryName("movie");
        event3.setLanguage("English");
        event3.setTitle("Deadpool & Wolverine");
        event3.setGenre("Superhero");
        event3.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event3.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event3.setVenueName("Forum Mall");
        event3.setLocation("Chennai");
        event3.setDate(Date.valueOf("2024-08-31"));
        event3.setTime(Time.valueOf("23:00:00"));
        testEvents.add(event3);

        EventDto event4 = new EventDto();
        event4.setCategoryName("movie");
        event4.setLanguage("English");
        event4.setTitle("Deadpool & Wolverine");
        event4.setGenre("Superhero");
        event4.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event4.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event4.setVenueName("Forum Mall");
        event4.setLocation("Chennai");
        event4.setDate(Date.valueOf("2024-09-01"));
        event4.setTime(Time.valueOf("14:00:00"));
        testEvents.add(event4);

        EventDto event5 = new EventDto();
        event5.setCategoryName("movie");
        event5.setLanguage("English");
        event5.setTitle("Deadpool & Wolverine");
        event5.setGenre("Superhero");
        event5.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event5.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event5.setVenueName("Forum Mall");
        event5.setLocation("Chennai");
        event5.setDate(Date.valueOf("2024-09-01"));
        event5.setTime(Time.valueOf("18:00:00"));
        testEvents.add(event5);

        EventDto event6 = new EventDto();
        event6.setCategoryName("movie");
        event6.setLanguage("English");
        event6.setTitle("Deadpool & Wolverine");
        event6.setGenre("Superhero");
        event6.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event6.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event6.setVenueName("Forum Mall");
        event6.setLocation("Chennai");
        event6.setDate(Date.valueOf("2024-09-01"));
        event6.setTime(Time.valueOf("22:00:00"));
        testEvents.add(event6);

        EventDto event7 = new EventDto();
        event7.setCategoryName("movie");
        event7.setLanguage("English");
        event7.setTitle("Deadpool & Wolverine");
        event7.setGenre("Superhero");
        event7.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event7.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event7.setVenueName("Spi Cinemas");
        event7.setLocation("Chennai");
        event7.setDate(Date.valueOf("2024-08-31"));
        event7.setTime(Time.valueOf("12:00:00"));
        testEvents.add(event7);

        EventDto event8 = new EventDto();
        event8.setCategoryName("movie");
        event8.setLanguage("English");
        event8.setTitle("Deadpool & Wolverine");
        event8.setGenre("Superhero");
        event8.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event8.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event8.setVenueName("Spi Cinemas");
        event8.setLocation("Chennai");
        event8.setDate(Date.valueOf("2024-08-31"));
        event8.setTime(Time.valueOf("18:00:00"));
        testEvents.add(event8);

        EventDto event9 = new EventDto();
        event9.setCategoryName("movie");
        event9.setLanguage("English");
        event9.setTitle("Deadpool & Wolverine");
        event9.setGenre("Superhero");
        event9.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event9.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event9.setVenueName("Spi Cinemas");
        event9.setLocation("Chennai");
        event9.setDate(Date.valueOf("2024-09-01"));
        event9.setTime(Time.valueOf("12:00:00"));
        testEvents.add(event9);

        EventDto event10 = new EventDto();
        event10.setCategoryName("movie");
        event10.setLanguage("English");
        event10.setTitle("Deadpool & Wolverine");
        event10.setGenre("Superhero");
        event10.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event10.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event10.setVenueName("Spi Cinemas");
        event10.setLocation("Chennai");
        event10.setDate(Date.valueOf("2024-09-02"));
        event10.setTime(Time.valueOf("18:00:00"));
        testEvents.add(event10);

        EventDto event11 = new EventDto();
        event11.setCategoryName("movie");
        event11.setLanguage("English");
        event11.setTitle("Deadpool & Wolverine");
        event11.setGenre("Superhero");
        event11.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event11.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event11.setVenueName("Spi Cinemas");
        event11.setLocation("Chennai");
        event11.setDate(Date.valueOf("2024-09-03"));
        event11.setTime(Time.valueOf("18:00:00"));
        testEvents.add(event11);

        EventDto event12 = new EventDto();
        event12.setCategoryName("movie");
        event12.setLanguage("English");
        event12.setTitle("Deadpool & Wolverine");
        event12.setGenre("Superhero");
        event12.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event12.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event12.setVenueName("Spi Cinemas");
        event12.setLocation("Chennai");
        event12.setDate(Date.valueOf("2024-09-04"));
        event12.setTime(Time.valueOf("18:00:00"));
        testEvents.add(event12);

        EventDto event13 = new EventDto();
        event13.setCategoryName("movie");
        event13.setLanguage("English");
        event13.setTitle("Deadpool & Wolverine");
        event13.setGenre("Superhero");
        event13.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event13.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event13.setVenueName("Sky Walk");
        event13.setLocation("Chennai");
        event13.setDate(Date.valueOf("2024-08-31"));
        event13.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event13);

        EventDto event14 = new EventDto();
        event14.setCategoryName("movie");
        event14.setLanguage("English");
        event14.setTitle("Deadpool & Wolverine");
        event14.setGenre("Superhero");
        event14.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event14.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event14.setVenueName("Sky Walk");
        event14.setLocation("Chennai");
        event14.setDate(Date.valueOf("2024-09-01"));
        event14.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event14);

        EventDto event15 = new EventDto();
        event15.setCategoryName("movie");
        event15.setLanguage("English");
        event15.setTitle("Deadpool & Wolverine");
        event15.setGenre("Superhero");
        event15.setImageUrl("https://m.media-amazon.com/images/M/MV5BNzRiMjg0MzUtNTQ1Mi00Y2Q5LWEwM2MtMzUwZDU5NmVjN2NkXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg");
        event15.setDescription("Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.");
        event15.setVenueName("Devi Cinemas");
        event15.setLocation("Chennai");
        event15.setDate(Date.valueOf("2024-08-31"));
        event15.setTime(Time.valueOf("16:00:00"));
        testEvents.add(event15);





        EventDto event16 = new EventDto();
        event16.setCategoryName("movie");
        event16.setLanguage("English");
        event16.setTitle("Inside Out 2");
        event16.setGenre("Adventure");
        event16.setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Inside_Out_2_poster.jpg/220px-Inside_Out_2_poster.jpg");
        event16.setDescription("A sequel that features Riley entering puberty and experiencing brand new, more complex emotions as a result. As Riley tries to adapt to her teenage years, her old emotions try to adapt to the possibility of being replaced.");
        event16.setVenueName("Forum Mall");
        event16.setLocation("Chennai");
        event16.setDate(Date.valueOf("2024-08-31"));
        event16.setTime(Time.valueOf("10:00:00"));
        testEvents.add(event16);

        EventDto event17 = new EventDto();
        event17.setCategoryName("movie");
        event17.setLanguage("English");
        event17.setTitle("Inside Out 2");
        event17.setGenre("Adventure");
        event17.setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Inside_Out_2_poster.jpg/220px-Inside_Out_2_poster.jpg");
        event17.setDescription("A sequel that features Riley entering puberty and experiencing brand new, more complex emotions as a result. As Riley tries to adapt to her teenage years, her old emotions try to adapt to the possibility of being replaced.");
        event17.setVenueName("Forum Mall");
        event17.setLocation("Chennai");
        event17.setDate(Date.valueOf("2024-08-31"));
        event17.setTime(Time.valueOf("18:00:00"));
        testEvents.add(event17);

        EventDto event18 = new EventDto();
        event18.setCategoryName("movie");
        event18.setLanguage("English");
        event18.setTitle("Inside Out 2");
        event18.setGenre("Adventure");
        event18.setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Inside_Out_2_poster.jpg/220px-Inside_Out_2_poster.jpg");
        event18.setDescription("A sequel that features Riley entering puberty and experiencing brand new, more complex emotions as a result. As Riley tries to adapt to her teenage years, her old emotions try to adapt to the possibility of being replaced.");
        event18.setVenueName("Forum Mall");
        event18.setLocation("Chennai");
        event18.setDate(Date.valueOf("2024-08-31"));
        event18.setTime(Time.valueOf("22:00:00"));
        testEvents.add(event18);

        EventDto event19 = new EventDto();
        event19.setCategoryName("movie");
        event19.setLanguage("English");
        event19.setTitle("Inside Out 2");
        event19.setGenre("Adventure");
        event19.setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Inside_Out_2_poster.jpg/220px-Inside_Out_2_poster.jpg");
        event19.setDescription("A sequel that features Riley entering puberty and experiencing brand new, more complex emotions as a result. As Riley tries to adapt to her teenage years, her old emotions try to adapt to the possibility of being replaced.");
        event19.setVenueName("Forum Mall");
        event19.setLocation("Chennai");
        event19.setDate(Date.valueOf("2024-09-01"));
        event19.setTime(Time.valueOf("10:00:00"));
        testEvents.add(event19);

        EventDto event20 = new EventDto();
        event20.setCategoryName("movie");
        event20.setLanguage("English");
        event20.setTitle("Inside Out 2");
        event20.setGenre("Adventure");
        event20.setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Inside_Out_2_poster.jpg/220px-Inside_Out_2_poster.jpg");
        event20.setDescription("A sequel that features Riley entering puberty and experiencing brand new, more complex emotions as a result. As Riley tries to adapt to her teenage years, her old emotions try to adapt to the possibility of being replaced.");
        event20.setVenueName("Forum Mall");
        event20.setLocation("Chennai");
        event20.setDate(Date.valueOf("2024-09-02"));
        event20.setTime(Time.valueOf("10:00:00"));
        testEvents.add(event20);

        EventDto event21 = new EventDto();
        event21.setCategoryName("movie");
        event21.setLanguage("English");
        event21.setTitle("Inside Out 2");
        event21.setGenre("Adventure");
        event21.setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Inside_Out_2_poster.jpg/220px-Inside_Out_2_poster.jpg");
        event21.setDescription("A sequel that features Riley entering puberty and experiencing brand new, more complex emotions as a result. As Riley tries to adapt to her teenage years, her old emotions try to adapt to the possibility of being replaced.");
        event21.setVenueName("Sky Walk");
        event21.setLocation("Chennai");
        event21.setDate(Date.valueOf("2024-08-31"));
        event21.setTime(Time.valueOf("12:00:00"));
        testEvents.add(event21);

        EventDto event22 = new EventDto();
        event22.setCategoryName("movie");
        event22.setLanguage("English");
        event22.setTitle("Inside Out 2");
        event22.setGenre("Adventure");
        event22.setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Inside_Out_2_poster.jpg/220px-Inside_Out_2_poster.jpg");
        event22.setDescription("A sequel that features Riley entering puberty and experiencing brand new, more complex emotions as a result. As Riley tries to adapt to her teenage years, her old emotions try to adapt to the possibility of being replaced.");
        event22.setVenueName("Sky Walk");
        event22.setLocation("Chennai");
        event22.setDate(Date.valueOf("2024-09-01"));
        event22.setTime(Time.valueOf("12:00:00"));
        testEvents.add(event22);

        EventDto event23 = new EventDto();
        event23.setCategoryName("movie");
        event23.setLanguage("English");
        event23.setTitle("Inside Out 2");
        event23.setGenre("Adventure");
        event23.setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Inside_Out_2_poster.jpg/220px-Inside_Out_2_poster.jpg");
        event23.setDescription("A sequel that features Riley entering puberty and experiencing brand new, more complex emotions as a result. As Riley tries to adapt to her teenage years, her old emotions try to adapt to the possibility of being replaced.");
        event23.setVenueName("Spi Cinemas");
        event23.setLocation("Chennai");
        event23.setDate(Date.valueOf("2024-08-31"));
        event23.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event23);

        EventDto event24 = new EventDto();
        event24.setCategoryName("movie");
        event24.setLanguage("English");
        event24.setTitle("Inside Out 2");
        event24.setGenre("Adventure");
        event24.setImageUrl("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Inside_Out_2_poster.jpg/220px-Inside_Out_2_poster.jpg");
        event24.setDescription("A sequel that features Riley entering puberty and experiencing brand new, more complex emotions as a result. As Riley tries to adapt to her teenage years, her old emotions try to adapt to the possibility of being replaced.");
        event24.setVenueName("Spi Cinemas");
        event24.setLocation("Chennai");
        event24.setDate(Date.valueOf("2024-09-01"));
        event24.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event24);



        EventDto event25 = new EventDto();
        event25.setCategoryName("movie");
        event25.setLanguage("Tamil");
        event25.setTitle("Kalki 2898 AD");
        event25.setGenre("Action");
        event25.setImageUrl("https://upload.wikimedia.org/wikipedia/en/4/4c/Kalki_2898_AD.jpg");
        event25.setDescription("A modern-day avatar of Vishnu, a Hindu god, who is believed to have descended to earth to protect the world from evil forces.");
        event25.setVenueName("Spi Cinemas");
        event25.setLocation("Chennai");
        event25.setDate(Date.valueOf("2024-09-01"));
        event25.setTime(Time.valueOf("18:00:00"));
        testEvents.add(event25);

        EventDto event26 = new EventDto();
        event26.setCategoryName("movie");
        event26.setLanguage("Tamil");
        event26.setTitle("Kalki 2898 AD");
        event26.setGenre("Action");
        event26.setImageUrl("https://upload.wikimedia.org/wikipedia/en/4/4c/Kalki_2898_AD.jpg");
        event26.setDescription("A modern-day avatar of Vishnu, a Hindu god, who is believed to have descended to earth to protect the world from evil forces.");
        event26.setVenueName("Spi Cinemas");
        event26.setLocation("Chennai");
        event26.setDate(Date.valueOf("2024-09-02"));
        event26.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event26);

        EventDto event27 = new EventDto();
        event27.setCategoryName("movie");
        event27.setLanguage("Tamil");
        event27.setTitle("Kalki 2898 AD");
        event27.setGenre("Action");
        event27.setImageUrl("https://upload.wikimedia.org/wikipedia/en/4/4c/Kalki_2898_AD.jpg");
        event27.setDescription("A modern-day avatar of Vishnu, a Hindu god, who is believed to have descended to earth to protect the world from evil forces.");
        event27.setVenueName("Forum Mall");
        event27.setLocation("Chennai");
        event27.setDate(Date.valueOf("2024-09-03"));
        event27.setTime(Time.valueOf("12:00:00"));
        testEvents.add(event27);

        EventDto event28 = new EventDto();
        event28.setCategoryName("movie");
        event28.setLanguage("Tamil");
        event28.setTitle("Kalki 2898 AD");
        event28.setGenre("Action");
        event28.setImageUrl("https://upload.wikimedia.org/wikipedia/en/4/4c/Kalki_2898_AD.jpg");
        event28.setDescription("A modern-day avatar of Vishnu, a Hindu god, who is believed to have descended to earth to protect the world from evil forces.");
        event28.setVenueName("Sky Walk");
        event28.setLocation("Chennai");
        event28.setDate(Date.valueOf("2024-09-04"));
        event28.setTime(Time.valueOf("12:00:00"));
        testEvents.add(event28);

        EventDto event29 = new EventDto();
        event29.setCategoryName("movie");
        event29.setLanguage("Tamil");
        event29.setTitle("Kalki 2898 AD");
        event29.setGenre("Action");
        event29.setImageUrl("https://upload.wikimedia.org/wikipedia/en/4/4c/Kalki_2898_AD.jpg");
        event29.setDescription("A modern-day avatar of Vishnu, a Hindu god, who is believed to have descended to earth to protect the world from evil forces.");
        event29.setVenueName("Sky Walk");
        event29.setLocation("Chennai");
        event29.setDate(Date.valueOf("2024-09-04"));
        event29.setTime(Time.valueOf("20:00:00"));
        testEvents.add(event29);



        EventDto event30 = new EventDto();
        event30.setCategoryName("movie");
        event30.setLanguage("Hindi");
        event30.setTitle("Bad Newz");
        event30.setGenre("Comedy");
        event30.setImageUrl("https://cdn.gulte.com/wp-content/uploads/2024/03/Tripti-Dimri-Badnewz-2-819x1024.jpg");
        event30.setDescription("Bad Newz is a bizarre, rare comedy about heteropaternal superfecundation! A twist of fate leads to Saloni Bagga`s twin pregnancy being fathered by both Akhil Chadha and Gurbir Pannu");
        event30.setVenueName("Sathyam cinemas");
        event30.setLocation("Chennai");
        event30.setDate(Date.valueOf("2024-09-10"));
        event30.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event30);

        EventDto event31 = new EventDto();
        event31.setCategoryName("movie");
        event31.setLanguage("Hindi");
        event31.setTitle("Bad Newz");
        event31.setGenre("Comedy");
        event31.setImageUrl("https://cdn.gulte.com/wp-content/uploads/2024/03/Tripti-Dimri-Badnewz-2-819x1024.jpg");
        event31.setDescription("Bad Newz is a bizarre, rare comedy about heteropaternal superfecundation! A twist of fate leads to Saloni Bagga`s twin pregnancy being fathered by both Akhil Chadha and Gurbir Pannu");
        event31.setVenueName("Sathyam cinemas");
        event31.setLocation("Chennai");
        event31.setDate(Date.valueOf("2024-09-11"));
        event31.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event31);



        EventDto event32 = new EventDto();
        event32.setCategoryName("concert");
        event32.setLanguage("Tamil");
        event32.setTitle("MaayaNadhi");
        event32.setGenre("Light Music");
        event32.setImageUrl("https://tse4.mm.bing.net/th/id/OIP.ARNBX7PQqv8WH_gRFbGLoAAAAA?rs=1&pid=ImgDetMain");
        event32.setDescription("A light music concert typically features a blend of instrumental and vocal performances that are designed to be easy on the ears and enjoyable for a wide audience.");
        event32.setVenueName("Arena");
        event32.setLocation("Chennai");
        event32.setDate(Date.valueOf("2024-08-16"));
        event32.setTime(Time.valueOf("16:00:00"));
        testEvents.add(event32);


        EventDto event33 = new EventDto();
        event33.setCategoryName("concert");
        event33.setLanguage("Hindi");
        event33.setTitle("Husn feels");
        event33.setGenre("Music");
        event33.setImageUrl("https://apnaaddafest.in/blog/content/images/2024/03/Screenshot-2024-03-29-190302.png");
        event33.setDescription("A light music concert typically features a blend of instrumental and vocal performances that are designed to be easy on the ears and enjoyable for a wide audience.");
        event33.setVenueName("Goddys cafe");
        event33.setLocation("Chennai");
        event33.setDate(Date.valueOf("2024-08-19"));
        event33.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event33);



        EventDto event34 = new EventDto();
        event34.setCategoryName("concert");
        event34.setLanguage("Korean");
        event34.setTitle("Map of the soul");
        event34.setGenre("Kpop");
        event34.setImageUrl("https://0.soompi.io/wp-content/uploads/2020/01/21173335/bts-tour-seoul.jpeg");
        event33.setDescription("BTS stands for the Korean phrase Bangtan Sonyeondan, which translates literally to 'Bulletproof Boy Scouts'. According to member J-Hope, the name signifies the group's desire.");
        event34.setVenueName("Nehru Stadium");
        event34.setLocation("Chennai");
        event34.setDate(Date.valueOf("2024-09-05"));
        event34.setTime(Time.valueOf("17:00:00"));
        testEvents.add(event34);


        EventDto event35 = new EventDto();
        event35.setCategoryName("concert");
        event35.setLanguage("English");
        event35.setTitle("Pentatonix");
        event35.setGenre("Kpop");
        event35.setImageUrl("https://concertposter.org/wp-content/uploads/2020/06/Pentatonix_2018SLC-rop.jpg");
        event35.setDescription("Pentatonix is a Grammy-winning a cappella group that performs covers and originals. Stream their latest album, watch their videos, and shop their official store for merchandise.");
        event35.setVenueName("Nehru Stadium");
        event35.setLocation("Chennai");
        event35.setDate(Date.valueOf("2024-08-15"));
        event35.setTime(Time.valueOf("17:00:00"));
        testEvents.add(event35);


        EventDto event36 = new EventDto();
        event36.setCategoryName("event");
        event36.setLanguage("English");
        event36.setTitle("Baking workshop");
        event36.setGenre("Skill development");
        event36.setImageUrl("https://tse1.mm.bing.net/th/id/OIP.ewntVSPYGtzcSg6fxSHpWgAAAA?rs=1&pid=ImgDetMain");
        event36.setDescription("Baking workshops are a delightful way to dive into the world of flour, butter, and sugar. Whether you’re a seasoned baker or a complete novice");
        event36.setVenueName("Soul Bistro");
        event36.setLocation("Chennai");
        event36.setDate(Date.valueOf("2024-12-15"));
        event36.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event36);


        EventDto event37 = new EventDto();
        event37.setCategoryName("event");
        event37.setLanguage("English");
        event37.setTitle("Open mic");
        event37.setGenre("Music");
        event37.setImageUrl("https://content.wepik.com/statics/112925158/preview-page0.jpg");
        event37.setDescription("An open mic (short for “open microphone”) is a live event where anyone from the audience can perform on stage. These events are typically held at venues like coffeehouses");
        event37.setVenueName("Besant Nagar");
        event37.setLocation("Chennai");
        event37.setDate(Date.valueOf("2024-09-16"));
        event37.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event37);


        EventDto event38 = new EventDto();
        event38.setCategoryName("event");
        event38.setLanguage("English");
        event38.setTitle("Haha -ed LALA");
        event38.setGenre("comedy");
        event38.setImageUrl("https://mir-s3-cdn-cf.behance.net/project_modules/hd/6c19c454067195.594bc36c25e57.jpg");
        event38.setDescription("It sounds like you’re interested in stand-up comedy related to the ER (Emergency Room). One notable comedian in this niche is Steven Ho, known online as Steveioe");
        event38.setVenueName("Hyatt");
        event38.setLocation("Chennai");
        event38.setDate(Date.valueOf("2024-10-06"));
        event38.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event38);


        EventDto event39 = new EventDto();
        event39.setCategoryName("event");
        event39.setLanguage("English");
        event39.setTitle("Fun potts");
        event39.setGenre("craft");
        event39.setImageUrl("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/pottery-classes-poster-design-template-ce1d9dc3ffb14372d21e1818c70d9b19_screen.jpg?ts=1577877729");
        event39.setDescription("An open mic (short for “open microphone”) is a live event where anyone from the audience can perform on stage. These events are typically held at venues like coffeehouses");
        event39.setVenueName("Lafayette");
        event39.setLocation("Chennai");
        event39.setDate(Date.valueOf("2024-11-16"));
        event39.setTime(Time.valueOf("15:00:00"));
        testEvents.add(event39);


       
        for (EventDto event : testEvents) {
            service.addEvents(event); 
        }
    }

    public void initialize() {
        initializeTestEvents();
    }
}
