import SearchBar from "../components/ui/SearchBar";
import Chip from "../components/ui/Chip";
import EventCard from "../components/feed/EventCard";
import HeroSection from "../components/home/HeroSection";
import CategoryScroller from "../components/home/CategoryScroller";
function Home() {
  return (
    <div className="min-h-screen bg-slate-100">

      <div className="max-w-5xl mx-auto p-6">
        <HeroSection/>

        <SearchBar />

        <div className="flex gap-3 overflow-x-auto py-6">

          <CategoryScroller />

        </div>

        <div className="space-y-8">

          <EventCard />

          <EventCard />

          <EventCard />

        </div>

      </div>

    </div>
  );
}

export default Home;