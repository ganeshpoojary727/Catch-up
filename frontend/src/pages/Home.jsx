import { useEffect, useState } from "react";
import SearchBar from "../components/ui/SearchBar";
import HeroSection from "../components/home/HeroSection";
import CategoryScroller from "../components/home/CategoryScroller";
import FeedSection from "../components/feed/FeedSection";
import { getAllEvents } from "../services/eventService";


function Home() {
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [search, setSearch] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("Trending");
  useEffect(() => {
   const loadEvents = async () => {
  try {
    setLoading(true);

const data = await getAllEvents();
    setEvents(data);
    setError(null);
  } catch (err) {
    console.error(err);
    setError("Failed to load events.");
  } finally {
    setLoading(false);
  }
};
  
  loadEvents();
  }, []);

const filteredEvents = events.filter((event) => {

  const matchesSearch =
    event.title.toLowerCase().includes(search.toLowerCase()) ||
    event.location.toLowerCase().includes(search.toLowerCase()) ||
    event.category.toLowerCase().includes(search.toLowerCase());

  const matchesCategory =
    selectedCategory === "Trending" ||
    event.category === selectedCategory;

  return matchesSearch && matchesCategory;
});
  return (
    <div className="min-h-screen bg-slate-100">
      <div className="max-w-5xl mx-auto p-6">
        <HeroSection />
       <SearchBar
    value={search}
    onChange={(e) => setSearch(e.target.value)}
/>
        <CategoryScroller
    selectedCategory={selectedCategory}
    onCategoryChange={setSelectedCategory}
/>

        <div className="space-y-8">
          <FeedSection
    title="📍 All Events"
    events={filteredEvents}
    loading={loading}
    error={error}
/>
        </div>
      </div>
    </div>
  );
}

export default Home;
