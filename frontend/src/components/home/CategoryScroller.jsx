import Chip from "../ui/Chip";

const categories = [
  "🔥 Trending",
  "💻 Technology",
  "🎵 Music",
  "🏍 Automotive",
  "⚽ Sports",
  "🎨 Art",
  "🎮 Gaming",
];

function CategoryScroller() {
  return (
    <section className="mb-8">
      <div className="flex gap-3 overflow-x-auto pb-2">
        {categories.map((category, index) => (
          <Chip key={category} active={index === 0}>
            {category}
          </Chip>
        ))}
      </div>
    </section>
  );
}

export default CategoryScroller;