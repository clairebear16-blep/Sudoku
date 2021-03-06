package com.example.sudoku;

public class Chain<E> {

    /**
     * internal class of chain to store what ever you want.
     */
    class Ring {

        /** Give an id to value you want to store. */
        private final String id;

        /** Value you want to store. */
        private E value;

        /** Previous ring on the chain. */
        private Ring previous;

        /**
         * create a ring with given value.
         *
         * @param setId       id of the ring
         * @param setValue    value of the ring
         * @param setPrevious previous ring
         */
        Ring(final String setId, final E setValue, final Ring setPrevious) {

            id = setId;
            value = setValue;
            previous = setPrevious;
        }

        /**
         * Get id of the ring.
         */
        String getId() {
            return id;
        }

        /**
         * Get value of the ring.
         */
        E getValue() {
            return value;
        }

        /**
         * Set ring value.
         *
         * @param setValue value you want to store.
         */
        void setValue(final E setValue) {
            value = setValue;
        }

        /**
         * Get previous ring.
         *
         * @return previous ring
         */
        Ring getPrevious() {
            return previous;
        }

        /**
         * Set previous ring.
         *
         * @param setPrevious Ring you want to be the previous one.
         */
        void setPrevious(final Ring setPrevious) {
            previous = setPrevious;
        }
    }

    /** The root ring on chain. */
    private Ring root;

    /** Construct an empty chain. */
    Chain() { }

    /**
     * Get root ring.
     *
     * @return root
     */
    Ring getRoot() {
        return root;
    }

    /**
     * Set root ring.
     *
     * @param setRoot root Ring you want to be
     */
    void setRoot(Ring setRoot) {
        root = setRoot;
    }

    /**
     * Add a ring to chain.
     *
     * @param id    id of the ring
     * @param value value you want to store
     * @return Ring itself
     */
    Ring add(final String id, final E value) {

        Ring ring = new Ring(id, value, root);
        root = ring;

        return ring;
    }

    /**
     * Get a ring from a specific ring on chain.
     *
     * @param current ring you want to start search
     * @param id      id of the ring
     * @return Ring if found. null if not
     */
    private Ring getFromId(final Ring current, final String id) {

        if (current == null || current.getId().equals(id)) {
            return current;
        }

        return getFromId(current.previous, id);
    }

    /**
     * Get a ring by its id.
     *
     * @param id id of the ring
     * @return Ring if found, null if not
     */
    Ring getById(final String id) {
        return getFromId(root, id);
    }


    /**
     * If you fucked up, use this to debug
     */
    public void printStack() {
        Ring current = root;

        while(current != null) {
            // // System.out.println("the current ring id is: " + current.getId());
            current = current.getPrevious();
        }
    }
}
