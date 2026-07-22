import SearchBar from "../components/ui/SearchBar";
import Chip from "../components/ui/Chip";
import EventCard from "../components/feed/EventCard";

function Home() {
  return (
    <div className="min-h-screen bg-slate-100">

      <div className="max-w-5xl mx-auto p-6">

        <SearchBar />

        <div className="flex gap-3 overflow-x-auto py-6">

          <Chip active>🔥 Trending</Chip>
          <Chip>💻 Technology</Chip>
          <Chip>🎵 Music</Chip>
          <Chip>🏍 Automotive</Chip>
          <Chip>⚽ Sports</Chip>
          <Chip>🎨 Art</Chip>
          <Chip>🎮 Gaming</Chip>

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