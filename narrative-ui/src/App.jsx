import React from 'react';
import { ReactFlow, Background, Controls } from '@xyflow/react';
import '@xyflow/react/dist/style.css';

// This is our initial "Post-it" (Node)
const initialNodes = [
  {
    id: '1',
    position: { x: 100, y: 100 },
    data: { label: 'Investigation Start: Headline 1' },
    style: { backgroundColor: '#fff9c4', padding: '10px', border: '1px solid #fbc02d' }
  },
];

const initialEdges = [];

export default function App() {
  return (
    <div style={{ width: '100vw', height: '100vh', backgroundColor: '#e5e5e5' }}>
      <ReactFlow nodes={initialNodes} edges={initialEdges}>
        <Background variant="dots" gap={12} size={1} />
        <Controls />
      </ReactFlow>
    </div>
  );
}