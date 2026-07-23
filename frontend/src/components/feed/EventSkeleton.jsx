function EventSkeleton() {
  return (
    <div className="bg-white rounded-2xl shadow-md overflow-hidden animate-pulse">

      <div className="h-56 bg-gray-200"></div>

      <div className="p-6 space-y-4">

        <div className="w-24 h-6 bg-gray-200 rounded-full"></div>

        <div className="w-2/3 h-8 bg-gray-200 rounded"></div>

        <div className="w-1/2 h-5 bg-gray-200 rounded"></div>

        <div className="flex justify-between">
          <div className="w-32 h-5 bg-gray-200 rounded"></div>
          <div className="w-24 h-5 bg-gray-200 rounded"></div>
        </div>

        <div className="flex gap-4">
          <div className="w-28 h-10 bg-gray-200 rounded-lg"></div>
          <div className="w-32 h-10 bg-gray-200 rounded-lg"></div>
        </div>

      </div>

    </div>
  );
}

export default EventSkeleton;