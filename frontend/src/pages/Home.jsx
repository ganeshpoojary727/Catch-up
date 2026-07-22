import { useEffect, useState } from "react";
import SearchBar from "../components/ui/SearchBar";
import HeroSection from "../components/home/HeroSection";
import CategoryScroller from "../components/home/CategoryScroller";
import FeedSection from "../components/feed/FeedSection";
import { getAllEvents } from "../services/eventService";

function Home() {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    const loadEvents = async () => {
      try {
        const data = await getAllEvents();
        setEvents(data);
      } catch (error) {
        console.error("Unable to load events:", error);
      }
    };

    loadEvents();
  }, []);

  return (
    <div className="min-h-screen bg-slate-100">
      <div className="max-w-5xl mx-auto p-6">
        <HeroSection />
        <SearchBar />
        <CategoryScroller />

        <div className="space-y-8">
          <FeedSection
    title="📍 All Events"
    events={events}
/>
        </div>
      </div>
    </div>
  );
}

export default Home;
